package dataStructures.Strings;

import dataStructures.Node;

/*
# String Node for Strings based on Lists.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of a String Node for Strings based on Lists
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class StringNode {
	public char character;
	StringNode next = null; //Pointer
	
	 public StringNode(){}
	  public StringNode(char value)
	  {
	      
	      this.character = value;
	      
	  }
	  public String toString()
	  {
	      return "Value: " + this.character + "\n"; 
	  }
	  public Node clone()
	  {
	      Node temp = new Node(this.character);
	      return temp;
	  }
	/**
	 * 
	 * @return
	 */
	

	
	public boolean isEqual(Node node) {
		if(this.character==node.value) {
			return true;
		}else {
			return false;
		}
	}
	
	
}