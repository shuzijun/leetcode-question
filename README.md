# leetcode-question
  [leetcode-editor](https://github.com/shuzijun/leetcode-editor) custom code demo    
## leetcode-editor config  
  CodeFileName:
  ```java
  $!velocityTool.camelCaseName(${question.titleSlug})
  ```
  CodeTemplate:
  ```java
    ${question.content}
    
    package com.shuzijun.leetcode.editor.en;
    public class $!velocityTool.camelCaseName(${question.titleSlug}){
        public static void main(String[] args) {
             Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
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
