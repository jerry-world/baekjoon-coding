class Solution {
    public String solution(String newId) {
        newId = newId.toLowerCase();
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        newId = newId.replaceAll("\\.+", ".");

        if (newId.charAt(0) == '.') newId = newId.substring(1);
        if (!newId.isEmpty() && newId.charAt(newId.length() - 1) == '.') newId = newId.substring(0, newId.length() - 1);
        if (newId.isEmpty()) newId = "a";
        if (newId.length() >= 16) newId = newId.substring(0, 15);
        if (newId.charAt(newId.length() - 1) == '.') newId = newId.substring(0, newId.length() - 1);
        if(newId.length()<=2){
            while (newId.length() != 3) {
                newId += newId.charAt(newId.length() - 1);
            }
        }

        return newId;
    }
}