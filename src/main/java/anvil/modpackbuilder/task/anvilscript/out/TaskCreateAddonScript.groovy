package anvil.modpackbuilder.task.anvilscript.out

import anvil.addonscript.AddonScriptJSON
import anvil.modpackbuilder.ManifestJSON
import anvil.modpackbuilder.Reader
import anvil.modpackbuilder.Writer
import anvil.modpackbuilder.task.ModpackBuilderTask
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.gradle.api.tasks.TaskAction

class TaskCreateAddonScript extends ModpackBuilderTask{

    TaskCreateAddonScript() {
        super()
        dependsOn("copyManifest", "copyModpackJSON")
    }

    @TaskAction
    public void action() {
            Gson gson = new GsonBuilder().create()
            ManifestJSON manifest = gson.fromJson(Reader.readFile(project.buildDir.getPath() + "/mc/json/manifest.json"), ManifestJSON.class)
            AddonScriptJSON addonscript = AddonScriptJSON.fromJSON(Reader.readFile(project.buildDir.getPath() + "/mc/json/modpack.json"))
            AddonScriptJSON json = new AddonScriptJSON();

            json.type = "modpack"

            if (manifest != null) {
                json.name = manifest.name
                json.id = manifest.name

                //Version
                AddonScriptJSON.Version version = new AddonScriptJSON.Version()
                json.versions = new ArrayList<>()
                json.versions.add(version)

                version.versionname = manifest.version;
                version.versionid = 1

                //File
                AddonScriptJSON.Version.File file = new AddonScriptJSON.Version.File()
                version.files = new ArrayList<>()
                version.files.add(file)
                file.type = "local"
                file.overrides = manifest.overrides

                //Relations
                version.relations = new ArrayList<>()
                for (ManifestJSON.File f : manifest.files) {
                    AddonScriptJSON.Version.Relation relation = new AddonScriptJSON.Version.Relation()
                    relation.type = "included"
                    relation.dir = "mods"
                    relation.linkType = "curseforge"
                    relation.projectID = f.projectID
                    relation.fileID = f.fileID
                    version.relations.add(relation)
                }

                if (addonscript != null && addonscript.versions != null && addonscript.versions.size() > 0 && addonscript.versions.get(0).relations != null) {
                    version.relations.addAll(addonscript.versions.get(0).relations)
                }

                new File(project.getBuildDir().getPath() + "/mc/addonscript").mkdirs()
                Writer.writeFile(new File(project.getBuildDir().getPath() + "/mc/addonscript/modpack.json"), json.toJSON())
            }
    }

}
