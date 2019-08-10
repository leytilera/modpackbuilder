package anvil.modpackbuilder.task.twitch;

import org.gradle.api.tasks.Copy;
import org.gradle.api.tasks.TaskAction;

public class TaskCopyManifest extends Copy {

    public TaskCopyManifest() {
        setGroup("modpackbuilder");
        from("src/twitch/manifest.json");
        into("build/mc/json");
    }

    @TaskAction
    public void action() {

    }

}
