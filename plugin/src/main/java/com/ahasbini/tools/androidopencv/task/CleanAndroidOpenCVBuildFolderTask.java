package fr.akylas.androidopencv.task;

import fr.akylas.androidopencv.PluginException;
import fr.akylas.androidopencv.internal.service.FilesManager;
import fr.akylas.androidopencv.internal.service.Injector;
import fr.akylas.androidopencv.internal.util.ExceptionUtils;
import fr.akylas.androidopencv.internal.util.Logger;

import org.gradle.api.DefaultTask;
import org.gradle.api.NonNullApi;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by ahasbini on 27-Nov-19.
 */
@NonNullApi
public class CleanAndroidOpenCVBuildFolderTask extends DefaultTask {

    private final Logger logger = Logger.getLogger(CleanAndroidOpenCVBuildFolderTask.class);
    private final ResourceBundle messages = Injector.getMessages();

    @TaskAction
    public void cleanAndroidOpenCVBuildFolder() {
        logger.debug("cleanAndroidOpenCVBuildFolder called");

        Project project = getProject();
        FilesManager filesManager = Injector.getFilesManager(project);

        logger.info("cleaning project Android OpenCV build directory");

        File androidOpenCVProjectBuildDir = new File(project.getBuildDir(),
                "androidopencv");
        if (!filesManager.checkOrCreateDirectory(androidOpenCVProjectBuildDir)) {
            throw new PluginException(String.format(messages.getString("cannot_create_dir"),
                    androidOpenCVProjectBuildDir.getAbsolutePath()));
        }

        File[] files = androidOpenCVProjectBuildDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.exists()) {
                    try {
                        filesManager.recursiveDelete(file);
                    } catch (IOException e) {
                        throw new PluginException("Unable to delete AndroidOpenCV " +
                                "build files.\n" +
                                ExceptionUtils.getCauses(e,
                                        messages.getString("caused_by")), e);
                    }
                    //noinspection ResultOfMethodCallIgnored
                    file.delete();
                }
            }
        }
    }

    @Override
    public String getName() {
        return "cleanAndroidOpenCVBuildFolder";
    }

    @Override
    public String getDescription() {
        return "Cleans AndroidOpenCV folder in project build directory.";
    }

    @Override
    public String getGroup() {
        return "AndroidOpenCV";
    }

}
