# leetcode-question
  [leetcode-editor](https://github.com/shuzijun/leetcode-editor) custom code demo     
  This branch is a private record branch. For configuration examples, please refer to master.    
## leetcode-editor config  
  CodeFileName:
  ```java
  Q${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})
  ```
  CodeTemplate:
  ```java
    package com.shuzijun.leetcode.editor.cn;
    ${question.content}
    
    public class Q${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args) {
        Solution solution = new Q${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        }
        ${question.code}
    }
  ```
  TemplateConstant:
  ```
    ${question.title}	question title	ex:Two Sum
    ${question.titleSlug}	question title slug 	ex:two-sum
    ${question.frontendQuestionId}	question serial number
    ${question.content}	question content
    ${question.code}	question code
    $!velocityTool.camelCaseName(str)	transform str camel case
  ```
