package anvil.modpackbuilder


class ManifestJSON {

    public String name
    public String version
    public String author
    public Minecraft minecraft
    public List<File> files
    public String overrides

    public static class Minecraft {
        public String version
    }

    public static class File {
        public int projectID
        public int fileID
        public boolean required
    }


}
