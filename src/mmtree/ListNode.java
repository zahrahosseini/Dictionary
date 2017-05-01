/*
 * ListNode.java
 *
 * Created on January 25, 2009, 1:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Zahra
 */
package mmtree;
public class ListNode {
    char info;
    ListNode link;
    /** Creates a new instance of ListNode */
    public ListNode() {
        info=' ';
        link=null;
    }
    public ListNode(char c)
    {
        info=c;
        link=null;
    }
    public ListNode(char c,ListNode lnk)
    {
        info = c;
        link=lnk;
    }
}
