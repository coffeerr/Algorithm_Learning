package Algorithm;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/10/19 9:38 上午
 */

import java.util.*;
import java.io.*;

public class CD161_2 {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;

        }

    }


    public static void main(String[] args) throws Exception {
     /*  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //将第一次换行符前的所以输入以空格分开并保存成字符串的形式
        String[] strings1 = bf.readLine().split(" ");

        //作为结果的输出流
        StringBuilder sb = new StringBuilder();
        //创建树
        TreeNode treeNode = createTreeCore(bf);

        //前序遍历
        preorder(treeNode,sb);
        //因为在前序遍历时会多添加一个空格，因此这里最后一个空格不能读取
        System.out.println(sb.substring(0,sb.length()-1));
        //清空
        sb.delete(0,sb.length());
        //中序遍历
        inorder(treeNode,sb);
        System.out.println(sb.substring(0,sb.length()-1));
        sb.delete(0,sb.length());
        backorder(treeNode,sb);
        System.out.println(sb.substring(0,sb.length()-1));
        */

        //采用输入流接收输入
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //将第一次换行符前的所以输入以空格分开并保存成字符串的形式
        String[] strings1 = bf.readLine().split(" ");

        //作为结果的输出流
        StringBuilder sb = new StringBuilder();
        //创建树
        TreeNode treeNode = createTreeCore(bf);

        //前序遍历
        preorder(treeNode, sb);
        //因为在前序遍历时会多添加一个空格，因此这里最后一个空格不能读取
        System.out.println(sb.substring(0, sb.length() - 1));
        //清空
        sb.delete(0, sb.length());
        //中序遍历
        inorder(treeNode, sb);
        System.out.println(sb.substring(0, sb.length() - 1));
        sb.delete(0, sb.length());
        backorder(treeNode, sb);
        System.out.println(sb.substring(0, sb.length() - 1));
    }
    /*

      //前序遍历
    private static void  preOrder(TreeNode treeNode,StringBuilder sb){
        if (treeNode==null){
            return ;
        }
        sb.append(treeNode.val+" ");
        preOrder(treeNode.left,sb);
        preOrder(treeNode.right,sb);

    }
    //中序遍历
    private static void innerOrder(TreeNode treeNode,StringBuilder sb){
        if (treeNode==null){
            return;
        }
        innerOrder(treeNode.left,sb);
        sb.append(treeNode.val);
        sb.append(" ");
        innerOrder(treeNode.right,sb);

    }
    private static void reviewOrder(TreeNode treeNode,StringBuilder sb){
        if (treeNode==null){
            return;
        }
        reviewOrder(treeNode.left,sb);
        reviewOrder(treeNode.right,sb);
        sb.append(treeNode.val);
        sb.append(" ");

    }
    */

    private static void preorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append(root.value);
        sb.append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    private static void inorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        inorder(root.left, sb);
        sb.append(root.value);
        sb.append(" ");
        inorder(root.right, sb);
    }

    private static void backorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        backorder(root.left, sb);

        backorder(root.right, sb);
        sb.append(root.value);
        sb.append(" ");
    }


    //创建一个树的结点
    private static TreeNode createTreeCore(BufferedReader in) throws Exception {
        //把一行转为整数
        int[] nodes = getIntArray(in.readLine());
        //数组中第一个数是根节点
        TreeNode node = new TreeNode(nodes[0]);
        //通过递归确定了层数
        if (nodes[1] != 0) {
            //左孩子
            node.left = createTreeCore(in);
        }
        if (nodes[2] != 0) {
            //右孩子
            node.right = createTreeCore(in);
        }
        return node;
    }

    //把接收到的字符串转换成整数
    private static int[] getIntArray(String str) {
        String[] temp = str.split(" ");
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = Integer.parseInt(temp[i]);
        }
        return result;
    }

    /*

  private  static TreeNode createTree(BufferedReader in) throws Exception{
        String[] s = in.readLine().split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        if(Integer.parseInt(s[1]) != 0)
            root.left = createTree(in);
        else
            root.left = null;
        if(Integer.parseInt(s[2]) != 0)
            root.right = createTree(in);
        else
            root.right = null;

        return root;

    }
    */

}
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Yang
 * @title: Main5
 * @projectName practice
 * @description: TODO
 * @date 2020/1/3/9:04
 */
/*
public class Main {
    //定义树结点
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    //创建一个树的结点
    private static TreeNode createTreeCore(BufferedReader in) throws Exception{
        //把一行转为整数
        int[] nodes = getIntArray(in.readLine());
        //数组中第一个数是根节点
        TreeNode node = new TreeNode(nodes[0]);
        //通过递归确定了层数
        if (nodes[1] != 0){
            //左孩子
            node.left = createTreeCore(in);
        }
        if (nodes[2] != 0){
            //右孩子
            node.right = createTreeCore(in);
        }
        return node;
    }

    //把接收到的字符串转换成整数
    private static int[] getIntArray(String str) {
        String[] temp = str.split(" ");
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = Integer.parseInt(temp[i]);
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        //采用输入流接收输入
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //将第一次换行符前的所以输入以空格分开并保存成字符串的形式
        String[] strings1 = bf.readLine().split(" ");

        //作为结果的输出流
        StringBuilder sb = new StringBuilder();
        //创建树
        TreeNode treeNode = createTreeCore(bf);

        //前序遍历
        preOrder(treeNode,sb);
        //因为在前序遍历时会多添加一个空格，因此这里最后一个空格不能读取
        System.out.println(sb.substring(0,sb.length()-1));
        //清空
        sb.delete(0,sb.length());
        //中序遍历
        innerOrder(treeNode,sb);
        System.out.println(sb.substring(0,sb.length()-1));
        sb.delete(0,sb.length());
        reviewOrder(treeNode,sb);
        System.out.println(sb.substring(0,sb.length()-1));
    }

    //前序遍历
    private static StringBuilder  preOrder(TreeNode treeNode,StringBuilder sb){
        if (treeNode==null){
            return null;
        }
        sb.append(treeNode.val+" ");
        preOrder(treeNode.left,sb);
        preOrder(treeNode.right,sb);
        return sb;
    }
    //中序遍历
    private static StringBuilder innerOrder(TreeNode treeNode,StringBuilder sb){
        if (treeNode==null){
            return null;
        }
        innerOrder(treeNode.left,sb);
        sb.append(treeNode.val);
        sb.append(" ");
        innerOrder(treeNode.right,sb);
        return sb;
    }
    private static StringBuilder reviewOrder(TreeNode treeNode,StringBuilder sb){
        if (treeNode==null){
            return null;
        }
        reviewOrder(treeNode.left,sb);
        reviewOrder(treeNode.right,sb);
        sb.append(treeNode.val);
        sb.append(" ");
        return sb;
    }
}
*/



