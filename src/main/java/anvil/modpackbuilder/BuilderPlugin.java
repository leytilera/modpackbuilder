package anvil.modpackbuilder;

import anvil.modpackbuilder.task.TaskCopyCfg;
import anvil.modpackbuilder.task.TaskCopyOverrides;
import anvil.modpackbuilder.task.TaskDeleteOverrides;
import anvil.modpackbuilder.task.TaskSetupModpackEnvironment;
import anvil.modpackbuilder.task.anvilscript.in.TaskCopyModpackJSON;
import anvil.modpackbuilder.task.anvilscript.in.TaskDeleteCache;
import anvil.modpackbuilder.task.anvilscript.in.TaskDownloadMods;
import anvil.modpackbuilder.task.anvilscript.out.TaskCreateAddonScript;
import anvil.modpackbuilder.task.twitch.TaskBuildTwitch;
import anvil.modpackbuilder.task.twitch.TaskCompileTwitch;
import anvil.modpackbuilder.task.twitch.TaskCopyManifest;
import anvil.modpackbuilder.task.twitch.TaskDeleteTwitch;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;

public class BuilderPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        TaskContainer tasks = project.getTasks();

        tasks.register("copyCfg", TaskCopyCfg.class);
        tasks.register("copyOverrides", TaskCopyOverrides.class);
        tasks.register("deleteOverrides", TaskDeleteOverrides.class);
        tasks.register("setupModpackEnvironment", TaskSetupModpackEnvironment.class);
        tasks.register("copyManifest", TaskCopyManifest.class);
        tasks.register("deleteTwitch", TaskDeleteTwitch.class);
        tasks.register("compileTwitch", TaskCompileTwitch.class);
        tasks.register("buildTwitch", TaskBuildTwitch.class);
        tasks.register("copyModpackJSON", TaskCopyModpackJSON.class);
        tasks.register("deleteCache", TaskDeleteCache.class);
        tasks.register("downloadMods", TaskDownloadMods.class);
        tasks.register("createAddonScript", TaskCreateAddonScript.class);

    }
}
