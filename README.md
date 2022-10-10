# leetcode-question

[leetcode-editor](https://github.com/shuzijun/leetcode-editor) custom code demo

## Progress

<!--START_SECTION_FLAG-->
![Progress](https://img.shields.io/static/v1?logo=leetcode&label=Progress&message=51%2F2812&color=brightgreen)  ![Easy](https://img.shields.io/static/v1?logo=leetcode&label=Easy&message=16&color=5CB85C)  ![Medium](https://img.shields.io/static/v1?logo=leetcode&label=Medium&message=30&color=F0AD4E)  ![Hard](https://img.shields.io/static/v1?logo=leetcode&label=Hard&message=5&color=D9534F)  <!--END_SECTION_FLAG-->

## leetcode-editor config

CodeFileName:

```java
Q${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})_test
```

CodeTemplate:

```go
  package main

  import "testing"
  
  ${q.content}
  
  func Test$!vt.camelCaseName(${q.codeMetaData.name})(t *testing.T) {
  
  }
  
  ${q.code}
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
