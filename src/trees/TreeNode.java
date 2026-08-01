package trees;

public class TreeNode {
    private Integer val;
    TreeNode left, right;


    public TreeNode(Integer val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

     public Integer getVal(){
        return val;
    }

    public void setVal(Integer val){
        this.val = val;
    }

    public void setLeftChild(TreeNode lnode){
        this.left = lnode;
    }

    public void setRightChild(TreeNode rnode){
        this.right =  rnode;
    }

    public TreeNode getLeftChild(){
        return this.left;
    }

    public TreeNode getRightChild(){
        return this.right;
    }
}



