package mmtree;

import java.io.FileReader;
import java.io.IOException;
/*
 * LinkList.java
 *
 * Created on January 25, 2009, 1:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Zahra
 */
public class LinkList {
    
    public static ListNode head;
    /** Creates a new instance of LinkList */
    public void traverse(ListNode next)
    {
        if(next!=null)
        {
            System.out.println(next.info);
            traverse(next.link);
        }
    }
    public static ListNode buildlist()throws Exception
    {
        head=new ListNode();
        head=null;
        ListNode last=new ListNode();
        char c=(char) System.in.read();
        while((int)c!=10)
        {
            ListNode node=new ListNode();
            node.info=c;
            node.link=null;
            if(head==null)
            {
                head=node;
                last=node;
            }
            else
            {
                last.link=node;
                last=node;
            }
          c=(char) System.in.read();
        }
        return head;
    }
    public ListNode buildlist(FileReader filename,char CHAR)
    {
     head=new ListNode();
        head=null;
        ListNode last=new ListNode();
        while(((int)CHAR!=13)&&((int)CHAR!=10))
        {
            ListNode node=new ListNode();
            node.info=CHAR;
            node.link=null;
            if(head==null)
            {
                head=node;
                last=node;
            }
            else
            {
                last.link=node;
                last=node;
            }
            try {
                CHAR=(char) filename.read();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return head;
    }
}
