package anvil.modpackbuilder.task.twitch

import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskAction

class TaskCompileTwitch extends Copy {

    TaskCompileTwitch() {
        setGroup("modpackbuilder")
        dependsOn("deleteTwitch", "copyManifest", "copyOverrides", "downloadMods", "deleteCache", "createAddonScript")
        into "build/mc/twitch"

        into(".") {
            from "build/mc/json/manifest.json"
        }

        into(".") {
            from "build/mc/addonscript/modpack.json"
        }

        into("overrides") {
            from "build/mc/overrides"
        }
    }

    @TaskAction
    public void action() {
    }

}
