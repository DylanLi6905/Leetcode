class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        // single '.' represents current
        // double '..' previous dir
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(String dir : split){
            if(dir.equals(".") || dir.equals("")){
                continue;
            } else if (dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }
        for(String top : stack){
            sb.append("/").append(top);
        }
        if(sb.length() == 0){
            return "/";
        }
        return sb.toString();
    }
}