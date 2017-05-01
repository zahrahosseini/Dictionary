package mmtree;
/*
 * SearchTree.java
 *
 * Created on January 25, 2009, 1:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Zahra
 */
public class SearchTree {
    
    /** Creates a new instance of SearchTree */
    public SearchTree() {
    }
   public boolean childnext(TreeNode cur,ListNode lcur)
    {
      TreeNode mcur=Find(cur,lcur);
      
      if((mcur.next!=null)&&(mcur.child!=null))
      {
          //cur=mcur;
          return true;
      }
      else
          return false;
    }
   public boolean haschild(TreeNode cur,ListNode lcur)
   {
       TreeNode mcur=cur.next;
       ListNode mlcur=lcur.link;
      /* while(mlcur!=null)
       {
           while(mcur!=null)
           {
               if((int)mcur.value==(int)mlcur.info)
                   break;
               else
               {
                   mcur=mcur.child;
               }
           }
               if(mcur.child!=null) return true;
               else
               {
                   mcur=mcur.next;
                   mlcur=mlcur.link;
               }
           
       }*/
       TreeNode ccur=cur;
       while(mlcur!=null)
       {
           ccur=Find(ccur,mlcur);
          // if((mlcur.link!=null)&&(ccur.is_end==true)) return true;
           if((ccur!=null)&&(ccur.child!=null)) return true;
           else 
           {
            mlcur=mlcur.link;
           }
       }
       cur=ccur;
       return false;
   }
   public TreeNode Delete(TreeNode cur,ListNode lcur)
   {
       TreeNode mcur=Find(cur,lcur);
       if(mcur.next==null)
       {
           if(cur.next==mcur)
           {
               mcur=mcur.child;
               cur.next=mcur;
           }
           else
           {
               TreeNode cmcur=cur.next;
               while(cmcur!=null)
               {
                   if((int)cmcur.child.value==(int)mcur.value)
                       break;
                   else
                       cmcur=cmcur.child;
               }
               cmcur.child=mcur.child;
               
           }
       }
       else
       {
           if(lcur.link!=null) return mcur;
           else 
           {
                mcur.is_end=false;
                return null;
           }
           
       }
       return null;
   }
       
  public void DelList(TreeNode cur,ListNode lcur)
  {
      TreeNode mcur=Find(cur,lcur);
      if(cur.next==mcur) cur.next=mcur.child;
      else
      {
          TreeNode cmcur=cur.next;
          while(cmcur!=null)
          {
              if((int)cmcur.child.value==(int)mcur.value) break;
              else cmcur=cmcur.child;
          }
          cmcur.child=mcur.child;
         
      }
  }
    public TreeNode Find(TreeNode cur,ListNode lcur)
   {
      TreeNode  mcur;
              if(cur.next!=null)
                  mcur=cur.next;
              else
                  mcur=null;
        while(mcur!=null)
        {
            if(mcur.value==(int)lcur.info)
            return mcur;
            else
                mcur=mcur.child;
        }
      System.out.println("NULL FIND");
      return null;
   }
    public boolean search(ListNode l,TreeNode tn)
    {
        TreeNode mtn=new TreeNode();
        mtn=tn;
        boolean t=false;
         if(tn.next!=null)
            mtn=tn.next;
            else
                return false;
        while(l!=null)
        {
            t=false;
           
            while(mtn!=null)
            {
                if( ((int)mtn.value) == ((int)l.info) )
                {
                    t=true;
                    break;
                }
                else
                    if(((int)mtn.value)<((int)l.info))
                    {
                        mtn=mtn.child;
                    }
                else
                     if(((int)mtn.value)>((int)l.info))
                 {
                    t=false;
                    break;
                 }
            }
            if(t==false)
            {
                System.out.println("error");
            //    System.out.println(l.info);
                return false;
            }
            else
            {
                if((l.link==null)&&(mtn.is_end==false)){return false;}
                l=l.link; tn=mtn;
                mtn=tn.next;
            }
        }
        return true;
    }
    public void display(TreeNode root)
    {
        if((root!=null)/*&&(root.is_end==false)*/)
        { 
            System.out.println((char)root.value);
            if(root.is_end==true)
            {
                System.out.println("true");
            }
            if(root.next!=null)
                display(root.next);
        }
    }
}
