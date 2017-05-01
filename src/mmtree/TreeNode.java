package mmtree;

import java.util.Currency;
import java.util.Enumeration;
import java.util.Stack;
/*
 * TreeNode.java
 *
 * Created on January 25, 2009, 1:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author Zahra
 */
public class TreeNode {
    
    /**
     * Creates a new instance of TreeNode
     */
    char value;
    TreeNode child,next;
   boolean  is_end;
   private boolean visited;
   private Stack stack;
    public TreeNode() {
    }
     public TreeNode(char CHAR) {
         value=CHAR;
         is_end=false;
         visited=false;
         child=next=null;  
    }
     public void PreOrder(TreeNode root)
     {
         if (root==null) return;
         root.visited=false;
         PreOrder(root.next);
         PreOrder(root.child);
     }
     private void traverse(Stack stack)  
     {
          Enumeration e = stack.elements();
    while ( e.hasMoreElements() )
      System.out.print( e.nextElement() );
          System.out.println(" ");
     }
     public void DFS(TreeNode root,Stack stack)
     {
         if(root!=null)
         {
             root.visited=true;
             char c=root.value;
             stack.push((char)c);
         }
         if(root.is_end==true) traverse(stack);
         if((root.next!=null)&&(root.next.visited==false)) DFS(root.next,stack);
         if((root.child!=null)&&(root.child.visited==false))
         {
             stack.pop();
             DFS(root.child,stack);
         }
        else
        {
             if(stack.isEmpty()==false)
             stack.pop();
             else return;
        }
         
     }
     public TreeNode insert (TreeNode cur, char Char)
     {
         if(cur.next==null)
         {
             TreeNode tcur=new TreeNode(Char);
             cur.next=tcur;
             return tcur;
         }
         else
         {
             TreeNode mcur= cur.next;
             if(((int)mcur.value)<=((int)Char))
             {
                 while(mcur!=null)
                 {
                     if(mcur.value==Char)
                         break;
                     else
                         if((mcur.child!=null)&&(((int)mcur.child.value)<=((int)Char)))
                         {
                         mcur=mcur.child;
                           if(mcur.value==Char)
                         break;
                         }
                         else
                             break;
                 }
                 if(((int)mcur.value!=((int)Char)))
                 {
                     TreeNode tcur=new TreeNode(Char);
                     tcur.child=mcur.child;
                     mcur.child=tcur;
                     return tcur;
                 }
                 else
                     return mcur;
                            
                 }
             else
             {
                 TreeNode tcur=new TreeNode(Char);
                 tcur.child=mcur;
                 cur.next=tcur;
                 return tcur;
             }
             }
         }
     
      private TreeNode ImaginaryInsert (TreeNode cur, char Char,boolean returntreenode)
     {
          returntreenode=false;
         if(cur.next==null)
         {
              returntreenode=true;
             return cur;
         }
         else
         {
             TreeNode mcur= cur.next;
             if(((int)mcur.value)<=((int)Char))
             {
                 while(mcur!=null)
                 {
                     if(mcur.value==Char)
                         break;
                     else
                         if((mcur.child!=null)&&(((int)mcur.child.value)<=((int)Char)))
                         {
                         mcur=mcur.child;
                           if(mcur.value==Char)
                         break;
                         }
                         else
                             break;
                 }
                 if(((int)mcur.value!=((int)Char)))
                 {
                     returntreenode=true;
                     return mcur;
                 }
                 else
                 {
                     returntreenode=false;
                     return mcur;
                 }
                            
             }    
             else
             {
                 returntreenode=true;
                 return mcur;
             }
             }
         }
         private  TreeNode ImaginaryInsertLocation(ListNode head,TreeNode root,Stack stack)
    {
        TreeNode kkroot=root;
        boolean fbool;
                while(head!=null)
                {
                    fbool=false;
                   kkroot=root.ImaginaryInsert(kkroot,head.info,fbool);
                   if(fbool==true)
                   {
                       return kkroot;
                   }
                   else
                       stack.push(kkroot.value);
                   if(head.link!=null)
                   head=head.link;
                   else
                   {
                       break;
                   }
                    //stack.pop();
                }
        return kkroot;
    }
          private void SimilarDFS(TreeNode root,Stack stack)
     {
          //    if(stack.firstElement()==stack.lastElement()) return;
         if(root!=null)
         {
             root.visited=true;
             char c=root.value;
             stack.push((char)c);
         }
         if(root.is_end==true) traverse(stack);
         if((root.next!=null)&&(root.next.visited==false)) SimilarDFS(root.next,stack);
         if((root.child!=null)&&(root.child.visited==false))
         {
             stack.pop();
             SimilarDFS(root.child,stack);
         }
        else
        {
             if(stack.isEmpty()==false)
             stack.pop();
             else return;
        }
         
     }
          public void  similar (TreeNode root,ListNode head)
          {
              root.PreOrder(root);
              Stack stack=new Stack();
              TreeNode loc=ImaginaryInsertLocation(head,root,stack);
              //System.out.println(loc.value);
             // traverse(stack);
             // if(head.link!=null)
              //System.out.println(head.link.info);
              if(loc.child!=null)
              {
                  stack.pop();
                  loc=loc.child;
              SimilarDFS(loc,stack);
              }
              else
              {
                  stack.pop();
                  SimilarDFS(loc,stack);
                // traverse(stack);
              }
             // DFS(root,stack);
          }
     }
     
