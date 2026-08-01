package trees;

public class Tree {
    private TreeNode root;
    private TreeNode searchedValue;

    public Tree(){
        searchedValue = null;
    }

    public void  Insert(Integer val){
        TreeNode parent = null;
        this.root = InsertHelper(this.root,parent, val);
    }


    private TreeNode InsertHelper(TreeNode rootNode, TreeNode parent, Integer val){
        if(rootNode == null){
            if(parent == null){
                TreeNode newNode = new TreeNode(val);
                rootNode = newNode;
                return rootNode;
            }else {
               return new TreeNode(val);
            }
        }else{
            // Do Recursion to Insert a new Value based on the value of the currentNode
            // if curr val is > root node val than traverse right until you find the correct place
            // if curr val is < root node val than traverse left and do search until you find correct place
            //setting parent as current Node
            parent = rootNode;
            if(val > rootNode.getVal()){
                parent.setRightChild(InsertHelper(rootNode.getRightChild(), parent, val));
            }else{
                parent.setLeftChild(InsertHelper(rootNode.getLeftChild(), parent, val));
            }
            return parent;
        }
    }

    public void InorderTraversal(){
        InorderHelper(this.root);
    }

    private void InorderHelper(TreeNode rootNode){
        if(rootNode == null){
            return;
        }else{
            InorderHelper(rootNode.getLeftChild());
            System.out.printf("%d -> ", rootNode.getVal());
            InorderHelper(rootNode.getRightChild());
        }
    }

    public void PostOrderTraversal(){
        PostOrderHelper(this.root);
    }

    private void PostOrderHelper(TreeNode rootNode){
        if(rootNode == null){
            return;
        }else{
            PostOrderHelper(rootNode.getLeftChild());
            PostOrderHelper(rootNode.getRightChild());
            System.out.printf("%d -> ", rootNode.getVal());
        }
    }


    public void PreOrderTraversal(){
        PreOrderHelper(this.root);
    }

    public void PreOrderHelper(TreeNode rootNode){
        if(rootNode == null){
            return;
        }
        System.out.printf("%d -> ", rootNode.getVal());
        PreOrderHelper(rootNode.getLeftChild());
        PreOrderHelper(rootNode.getRightChild());

    }

    public TreeNode delTreeNode(Integer val){
        return null;
    }

    public TreeNode isNodePresent(Integer val){  // search time is log(n) becuase we are having 64 nodes log,base2 (64) 6 in balanced binay tree
        TreeNode res = null;
        isPresentHelper(this.root, val);
        if(searchedValue != null){
            res = searchedValue;
            searchedValue = null;
        }
        return  res;
    }

    public void isPresentHelper(TreeNode rootNode, Integer val){
        if(rootNode == null){
            return;
        }else{
            isPresentHelper(rootNode.getLeftChild(), val);
            if(val == rootNode.getVal()){
                this.searchedValue =  rootNode;
            }
            isPresentHelper(rootNode.getRightChild(), val);
        }
    }
}
