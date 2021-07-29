public class RemoveCharactesFromString {
    public static void main(String[] args) {
        String str = "There Are Characters That Must Be Removed In This String";
        String remove = "es";
        System.out.println("Thr Ar Charactr That Mut B Rmovd In Thi String : " + RemoveCharactesFromString.removeCharactesFromString(str, remove));
    }

    public static String removeCharactesFromString(String str, String charactersToRemove) {
        char[] strArray = str.toCharArray();
        char[] removeArray = charactersToRemove.toCharArray();
        boolean[] flags = new boolean[128];

        for (int i = 0; i < removeArray.length; i++) {
            char c = removeArray[i];
            flags[c] = true;
        }
        int dest = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (!flags[strArray[i]]) {
                strArray[dest++] = strArray[i];
            }
        }

        return new String(strArray, 0, dest);


    }
}
