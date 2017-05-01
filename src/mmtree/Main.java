/*
 * Main.java
 *
 * Created on January 25, 2009, 12:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mmtree;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object;
import java.util.Enumeration;
import java.util.Stack;
import javax.naming.directory.SearchResult;

/**
 *
 * @author Zahra
 */
public class Main {
    
    static public char getChar() throws IOException
{
    char ch = (char) System.in.read();
    flushInput(); // This clears out System.in
    return ch;
}
// *******************************************************
// method flushInput: reads System.in until newline
// *******************************************************
static public void flushInput() throws IOException
{
     while ( (char) System.in.read() != '\n' )
       ; // do nothing
      }
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void insert(ListNode head,TreeNode root)
    {
        TreeNode kkroot=root;
                while(head!=null)
                {
                   kkroot=root.insert(kkroot,head.info);
                   if(head.link!=null)
                   head=head.link;
                   else
                   {
                       kkroot.is_end=true;
                       break;
                   }
                }
    }
     public static  TreeNode lastchild(TreeNode cur,ListNode lcur,SearchTree st)
   {
       TreeNode mcur=cur.next;
       ListNode mlcur=lcur.link;
       TreeNode ccur=cur;
       while(mlcur!=null)
       {
           ccur=st.Find(ccur,mlcur);
          // if((mlcur.link!=null)&&(ccur.is_end==true)) return true;
         //  if((ccur!=null)&&(ccur.child!=null)) return true;
         //  else 
        //   {
            mlcur=mlcur.link;
          // }
       }
       cur=ccur;
       return ccur;
   }
      public static  TreeNode hasEnd(TreeNode cur,ListNode lcur,SearchTree st, boolean flag)
   {
       TreeNode mcur=cur.next;
       ListNode mlcur=lcur.link;
       TreeNode ccur=cur;
       TreeNode rec=null;
       ListNode tlcur=lcur;
       boolean f=false;
       TreeNode tf=ccur;
       TreeNode reccur=cur;
       while(mlcur!=null)
       {
           tf=ccur;
           ccur=st.Find(ccur,mlcur);
           if((mlcur.link!=null)&&(ccur.is_end==true)) //return true;
           {
               f=true;
               rec=ccur;
               tlcur=mlcur;
            //   System.out.println(rec.value);
            //   System.out.println(tf.value);
               reccur=tf;
           }
          // if((ccur!=null)&&(ccur.child!=null)) return true;
          // else 
          // {
            mlcur=mlcur.link;
          // }
       }
       flag=f;
       cur=reccur;
       lcur=tlcur;
       if(rec!=null)
           return rec;
       else
           return null;
   }
        public static  ListNode listfind(TreeNode cur,ListNode lcur,SearchTree st, boolean flag)
   {
       TreeNode mcur=cur.next;
       ListNode mlcur=lcur.link;
       TreeNode ccur=cur;
       TreeNode rec=null;
       ListNode tlcur=lcur;
       boolean f=false;
       TreeNode tf=ccur;
       TreeNode reccur=cur;
       while(mlcur!=null)
       {
           tf=ccur;
           ccur=st.Find(ccur,mlcur);
           if((mlcur.link!=null)&&(ccur.is_end==true)) //return true;
           {
               f=true;
               rec=ccur;
               tlcur=mlcur;
            //   System.out.println(rec.value);
              // System.out.println(tf.value);
               reccur=tf;
           }
          // if((ccur!=null)&&(ccur.child!=null)) return true;
          // else 
          // {
            mlcur=mlcur.link;
          // }
       }
       flag=f;
       cur=reccur;
       lcur=tlcur;
       if(rec!=null)
           return tlcur;
       else
           return null;
   }
    public static void Delete(ListNode head, TreeNode root,SearchTree st)
    {
          TreeNode cur=root;
          ListNode mhead=new ListNode();
          mhead.link=head;
       //   if((st.search(head,root)==true)&&(st.haschild(root,mhead)==false))
        //      st.DelList(root,head);
        //  else
        if(st.search(head,cur))
                    {
                        if(head.link!=null)
                        {
                            while(head!=null)
                            {
                                if(st.childnext(cur,head)==true)//Has child & next
                                {
                                  //  System.out.println("has next &  child");
                                    TreeNode mcur=st.Find(cur,head);
                                    if(st.haschild(mcur,head)==false)  // Has child=false
                                    {
                                      //  System.out.println("has no child");
                                       TreeNode tmcur=lastchild(mcur,head,st);
                                        //System.out.println(mcur.value);
                                       boolean tnflag=false;
                                       TreeNode mmcur=mcur;
                                       ListNode tthead=head;
                                       TreeNode tnend=hasEnd(mmcur,tthead,st,tnflag);
                                        if(tnend!=null)
                                        {
                                        //   System.out.println("has end =true");
                                           //System.out.println(tnend.value);
                                           ListNode tfind=listfind(mmcur,tthead,st,tnflag);
                                        //   System.out.println(tfind.info);
                                           if(tmcur.next==null)
                                          st.DelList(tnend,tfind.link);
                                           else
                                           {
                                              // System.out.println("*****");
                                             //  System.out.println(tmcur.value);
                                               tmcur.is_end=false;
                                           }
                                        }
                                        else
                                        if(tmcur.next!=null)
                                            tmcur.is_end=false;
                                       else
                                       st.DelList(cur,head);
                                        
                                        break;
                                    }
                                    else
                                        cur=mcur;
                                }
                                else
                                    cur=st.Delete(cur,head);
                                head=head.link;
                            }
                        }
                        else // head.link==null
                        {
                         //  System.out.println("head.link==null");
                            TreeNode mcur=st.Find(cur,head);
                            if(mcur.next!=null) mcur.is_end=false;
                            else  st.DelList(cur,head);
                        }
                    }
                    else
                        System.out.println("SEARCH:NOT FOUND");
    }
    public static String ReadString()throws Exception
    {
        char newchar;
        String string=new String();
        newchar=(char)System.in.read();
        while(newchar!='\n')
        {
            string=string+newchar;
            newchar=(char)System.in.read();
        }
        return string;
    }
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        char DOCHAR=getChar();
      LinkList s=new LinkList();
      ListNode head=new ListNode();
      SearchTree st=new SearchTree();
       TreeNode root=new TreeNode();
      // System.out.println(":Press i to insert press s to search:");
        while (true)
        {
            switch (DOCHAR)
            {
            case 'i':
                case 'I':
            //if(DOCHAR=='i')
            {
                try {
                   head=s.buildlist();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
               // s.traverse(head);
                ////////////////
               insert(head,root);
                /*TreeNode kkroot=root;
                while(head!=null)
                {
                   kkroot=root.insert(kkroot,head.info);
                   if(head.link!=null)
                   head=head.link;
                   else
                   {
                       kkroot.is_end=true;
                       break;
                   }
                }*/
                
                //st.display(root.next);
                break;
            }
            // DOCHAR=getChar();
             //break;
                case 'd':
                case'D':
                {
                    head=null;
                    try {
                   head=s.buildlist();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                    Delete(head,root,st);
             /*      TreeNode cur=root;
                    if(st.search(head,cur))
                    {
                        while(head!=null)
                        {
                            if(st.childnext(cur,head)==true)//Has child & next
                            {
                                TreeNode mcur=st.Find(cur,head);
                                if(st.haschild(mcur,head)==false)  // Has child=false
                                {
                                   st.DelList(cur,head);
                                    break;
                                }
                                else
                                    cur=mcur;
                            }
                            else
                                cur=st.Delete(cur,head);
                            head=head.link;
                        }
                    }
                    else
                        System.out.println("SEARCH:NOT FOUND");*/
                    break;
                }
                case'f':
                {
                    char fileaction=getChar();
                    switch(fileaction)
                    {
                        case 'i':
                        {
                            System.out.println("Write your file name:");
                            String fileloc="";
                            try {
                                fileloc=ReadString();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                           // System.out.println(fileloc);C:\\Users\\Zahra\\Downloads\\Desktop\\a.txt
                            FileReader read=new FileReader(fileloc);
                            int nextchar;
                            nextchar=read.read();
                            while(nextchar!=-1)
                            {
                                if(((int)nextchar!=13)&&((int)nextchar!=10))
                                  head=s.buildlist(read,(char)nextchar);
                                else
                                {
                                  insert(head,root);
                                }
                                nextchar=read.read();
                            }
                            break;
                        }
                        case 'd':
                        {
                            System.out.println("Write your file name:");
                            String fileloc="";
                            try {
                                fileloc=ReadString();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                             FileReader read=new FileReader(fileloc);
                             System.out.println("write your file log name:");
                              String writeloc=" ";
                                        try {
                                            writeloc = ReadString();
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                     FileWriter write=new FileWriter(writeloc);
                            int nextchar;
                            nextchar=read.read();
                            while(nextchar!=-1)
                            {
                                if(((int)nextchar!=13)&&((int)nextchar!=10))
                                  head=s.buildlist(read,(char)nextchar);
                                else
                                {
                                    if(st.search(head,root))
                                    {
                                        Delete(head,root,st);
                                        write.write("Deleted");
                                    }
                                    else
                                    { 
                                         write.write("NOT FOUND");
                                    }
                                    write.write(13);
                                    write.write(10);
                                    write.flush();
                                }
                                nextchar=read.read();
                            
                            }
                                try {
                                    write.close();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            break;
                        }
                        case 's':
                        {
                             
                            System.out.println("Write your file name:");
                            String fileloc="";
                            try {
                                fileloc=ReadString();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                             FileReader read=new FileReader(fileloc);
                             System.out.println("write your file log name:");
                              String writeloc=" ";
                                        try {
                                            writeloc = ReadString();
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                     FileWriter write=new FileWriter(writeloc);
                            int nextchar;
                            nextchar=read.read();
                            while(nextchar!=-1)
                            {
                                if(((int)nextchar!=13)&&((int)nextchar!=10))
                                  head=s.buildlist(read,(char)nextchar);
                                else
                                {
                                    if(st.search(head,root))
                                    {
                                        write.write("yes");
                                    }
                                    else
                                    { 
                                         write.write("no");
                                    }
                                    write.write(13);
                                    write.write(10);
                                    write.flush();
                                }
                                nextchar=read.read();
                            
                            }
                                try {
                                    write.close();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            break;
                        }
                    }
                    break;
                    
                }
             case 's':
                case 'S':
             //if(DOCHAR=='s')
             {
                s=new LinkList();
                  head=new ListNode();
                try {
                   head=s.buildlist();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
               // s.traverse(head);
                  st=new SearchTree();
                 if(st.search(head,root)==true)
                     System.out.println("TRUE");
                 else
                     System.out.println("False");
                  break;
             }
                case 'p':
                {
                    root.PreOrder(root);
                    Stack stack=new Stack();
                    root.DFS(root,stack);
                    break;
                }
                case'm':
                {
                       head=new ListNode();
                try {
                   head=s.buildlist();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                    if(st.search(head,root)==false)
                       root.similar(root,head);
                    break;
                }
             default:
             break;
            }
         //   System.out.println(":Press i to insert press s to search:");
            DOCHAR=getChar();
        }
    }
}