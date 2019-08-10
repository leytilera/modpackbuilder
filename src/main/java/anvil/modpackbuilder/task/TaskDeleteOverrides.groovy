package anvil.modpackbuilder.task;

import org.gradle.api.tasks.Delete;
import org.gradle.api.tasks.TaskAction;

public class TaskDeleteOverrides extends Delete {

    public TaskDeleteOverrides() {
        setGroup("modpackbuilder");
        delete("build/mc/overrides");
    }

    @TaskAction
    public void action() {

    }

}
