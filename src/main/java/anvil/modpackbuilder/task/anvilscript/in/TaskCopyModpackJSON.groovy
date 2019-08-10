package anvil.modpackbuilder.task.anvilscript.in

import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskAction

class TaskCopyModpackJSON extends Copy {

    TaskCopyModpackJSON() {
        setGroup("modpackbuilder")
        from("src/addonscript/modpack.json")
        into("build/mc/json")
    }

    @TaskAction
    public void action() {
    }

}
