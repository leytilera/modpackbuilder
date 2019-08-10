package anvil.modpackbuilder.task.anvilscript.in

import anvil.addonscript.AddonScriptJSON
import anvil.addonscript.install.Install
import anvil.modpackbuilder.Reader
import anvil.modpackbuilder.task.ModpackBuilderTask
import org.gradle.api.tasks.TaskAction

class TaskDownloadMods extends ModpackBuilderTask {

    TaskDownloadMods() {
        super()
        dependsOn("copyModpackJSON", "deleteCache")
    }

    @TaskAction
    public void action() {
            AddonScriptJSON json = AddonScriptJSON.fromJSON(Reader.readFile(project.getBuildDir().getPath() + "/mc/json/modpack.json"))
            if (json != null && json.versions.size() > 0 && json.versions.get(0).relations != null) {
                for (AddonScriptJSON.Version.Relation relation : json.versions.get(0).relations) {
                    if (relation.type.equals("included") && relation.linkType.equals("file")) {
                        Install.installRelation(relation, project.getBuildDir().getPath() + "/mc/overrides/")
                    }
                }
            }
    }

}
