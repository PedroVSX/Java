package ArvoreBusca;

public class ArvoreBusca {
    private Node root;

    public ArvoreBusca() {
        root = null;
    }

    public void add(int elem) {
        if (root == null) {
            root = new Node(elem);
        } else {
            add(elem, root);
        }
    }

    private void add(int elem, Node branch) {
        if (elem < branch.value) {

            if (branch.leftChild == null) {
                branch.leftChild = new Node(elem);
            } else {
                add(elem, branch.leftChild);
            }

        } else {

            if (branch.rightChild == null) {
                branch.rightChild = new Node(elem);
            } else {
                add(elem, branch.rightChild);
            }

        }
    }

    public boolean search(int elem) {
        if (root == null) {
            return false;
        } else {
            return search(elem, root);
        }
    }

    private boolean search(int elem, Node branch) {
        if (elem == branch.value) {
            return true;

        } else if (elem < branch.value) {

            if (branch.leftChild == null) {
                return false;
            } else {
                return search(elem, branch.leftChild);
            }

        } else {

            if (branch.rightChild == null) {
                return false;
            } else {
                return search(elem, branch.rightChild);
            }

        }
    }

    public void remove(int elem) {
        if (root != null) {
            remove(elem, root, null);
        }
    }

    private void remove(int elem, Node branch, Node parent) {
        if (elem == branch.value) {

            if (branch.leftChild == null && branch.rightChild == null) {

                if (branch == parent.leftChild) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }

            } else if (branch.leftChild != null && branch.rightChild == null) {

                if (branch == parent.leftChild) {
                    parent.leftChild = branch.leftChild;
                } else {
                    parent.rightChild = branch.leftChild;
                }

            } else if (branch.leftChild == null && branch.rightChild != null) {

                if (branch == parent.leftChild) {
                    parent.leftChild = branch.rightChild;
                } else {
                    parent.rightChild = branch.rightChild;
                }

            } else {
                branch.value = min(branch.rightChild);
                remove(branch.value, branch.rightChild, branch);
            }

        } else if (elem < branch.value) {

            if (branch.leftChild != null) {
                remove(elem, branch.leftChild, branch);
            }

        } else {

            if (branch.rightChild != null) {
                remove(elem, branch.rightChild, branch);
            }

        }
    }

    private int min(Node branch) {
        if (branch.leftChild == null) {
            return branch.value;
        } else {
            return min(branch.leftChild);
        }
    }

    public void showPreOrder() {
        if (root != null) {
            showPreOrder(root);
            System.out.println();
        }
    }

    private void showPreOrder(Node branch) {
        System.out.print(branch.value + " ");

        if (branch.leftChild != null) {
            showPreOrder(branch.leftChild);
        }

        if (branch.rightChild != null) {
            showPreOrder(branch.rightChild);
        }
    }

    public void showInOrder() {
        if (root != null) {
            showInOrder(root);
            System.out.println();
        }
    }

    private void showInOrder(Node branch) {
        if (branch.leftChild != null) {
            showInOrder(branch.leftChild);
        }

        System.out.print(branch.value + " ");

        if (branch.rightChild != null) {
            showInOrder(branch.rightChild);
        }
    }

    public void showPostOrder() {
        if (root != null) {
            showPostOrder(root);
            System.out.println();
        }
    }

    private void showPostOrder(Node branch) {
        if (branch.leftChild != null) {
            showPostOrder(branch.leftChild);
        }

        if (branch.rightChild != null) {
            showPostOrder(branch.rightChild);
        }

        System.out.print(branch.value + " ");
    }
}
