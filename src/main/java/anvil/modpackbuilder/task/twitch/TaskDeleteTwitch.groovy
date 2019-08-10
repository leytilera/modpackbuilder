package anvil.modpackbuilder.task.twitch;

import org.gradle.api.tasks.Delete;
import org.gradle.api.tasks.TaskAction;

public class TaskDeleteTwitch extends Delete {

    public TaskDeleteTwitch() {
        setGroup("modpackbuilder");
        delete("build/mc/twitch");
    }

    @TaskAction
    public void action() {

    }

}
