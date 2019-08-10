package anvil.modpackbuilder.task.anvilscript.in

import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.TaskAction

class TaskDeleteCache extends Delete {

    TaskDeleteCache() {
        setGroup("modpackbuilder")
        delete("build/mc/overrides/cache")
    }

    @TaskAction
    public void action() {

    }

}
