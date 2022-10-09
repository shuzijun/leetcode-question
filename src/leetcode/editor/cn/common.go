package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func (n *ListNode) String() string {
	if n == nil {
		return ""
	}
	if n.Next == nil {
		return fmt.Sprintf("%d", n.Val)
	}
	return fmt.Sprintf("%d", n.Val) + " -> " + n.Next.String()
}
