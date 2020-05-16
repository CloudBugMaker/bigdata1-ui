package com.thintime.bigdataui.fragment;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Thintime
 * @create 2020/4/28
 * @desc todo 碎片化知识3：二叉树，每个结点最多有2个子树的树结构
 * @note 每个结点的深度 = 左右子树最大深度 + 1，即max(root)=max( max(root.left),max(root.right) )+1
 */
public class BinaryTree {
    /**
     * @hint 给定二叉树[3,9,20,null,null,15,7]，找出最大深度
     *              3
     *             / \
     *            9  20
     *               / \
     *              15  7
     * @result max(root-3)=max( max(sub-9),max(sub-20) )+1
     *                    =max( 1,max( max(sub-15),max(sub-7) )+1 )+1
     *                    =max( 1,max(1,1)+1 )+1
     *                    =2+1=3
     * @remark 递归层次过深，占用的栈资源可能会超过线程最大值，从而导致栈溢出程序异常退出
     * @note 基本所有的递归转非递归，都可以通过栈来实现
     */

    /**
     * @desc 非递归的DFS(深度优先算法)
     *               a
     *             /   \
     *            b     c
     *           / \   / \
     *          d   e  f  g
     * @parse 1:将a压入栈push           2:a弹栈pop，将c、b压入栈(注意顺序，要将先访问的数据后压入栈)   ...
     */

    /**
     *  @desc BST(二叉搜索树)：若左子树非空，则左子树上所有结点值均小于根结点值；若右子树非空，则右子树上所有结点值均大于根结点值
     */
}
