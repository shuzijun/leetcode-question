# leetcode-question
  [leetcode-editor](https://github.com/shuzijun/leetcode-editor) custom code demo    
## Progress
<!--START_SECTION_FLAG-->
![Progress](https://img.shields.io/static/v1?logo=leetcode&label=Progress&message=47%2F2647&color=brightgreen)  ![Easy](https://img.shields.io/static/v1?logo=leetcode&label=Easy&message=58&color=5CB85C)  ![Medium](https://img.shields.io/static/v1?logo=leetcode&label=Medium&message=106&color=F0AD4E)  ![Hard](https://img.shields.io/static/v1?logo=leetcode&label=Hard&message=12&color=D9534F)  <!--END_SECTION_FLAG-->
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
