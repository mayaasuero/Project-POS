public class FinalProjNode {
 public int info;
 public FinalProjNode next;
 public FinalProjNode(int i) {
 this (i, null);
 }
 public FinalProjNode(int i, FinalProjNode n) {
 info = i; next = n;
 }
 }