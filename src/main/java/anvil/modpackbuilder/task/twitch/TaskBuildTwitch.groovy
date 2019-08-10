package anvil.modpackbuilder.task.twitch

import anvil.modpackbuilder.ManifestJSON
import anvil.modpackbuilder.Reader
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.bundling.Zip

class TaskBuildTwitch extends Zip {

    Gson gson;

    TaskBuildTwitch() {
        setGroup("modpackbuilder")
        dependsOn("compileTwitch")

        gson = new GsonBuilder().create()
        ManifestJSON manifest = gson.fromJson(Reader.readFile(project.buildDir.getPath() + "/mc/json/manifest.json"), ManifestJSON.class)
        from "build/mc/twitch"
        extension = "zip"
        if (manifest != null)
            version = manifest.version
        if (manifest != null)
            baseName = manifest.name
        appendix = "twitch"

        destinationDir = new File(project.buildDir.getPath() + "/libs/")
    }

    @TaskAction
    public void action() {


        }

}
