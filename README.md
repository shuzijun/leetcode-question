# leetcode-question
  [leetcode-editor](https://github.com/shuzijun/leetcode-question) custom code demo    
## leetcode-editor config  
  CodeFileName:
  ```java
  $!velocityTool.camelCaseName(${question.titleSlug})
  ```
  TemplateConstant:
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