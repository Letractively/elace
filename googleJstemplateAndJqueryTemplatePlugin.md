为了解决拼接html带来的代码臭味，我们决定使用template的方式解决。调研了两个解决方案，分别是：
  1. google jstemplate
  1. jquery template plugin
下面一一介绍一下两个js库的使用方法。
### 1.google jstemplate ###
#### 官网地址 ####
http://code.google.com/intl/zh-CN/apis/jstemplate/
#### 使用介绍 ####
要使用jstemplate，首先应该在文件中引入jstemplate的库。
```
<script src="util.js" type="text/javascript"></script>
<script src="jsevalcontext.js" type="text/javascript"></script>
<script src="jstemplate.js" type="text/javascript"></script>
```
  * helloworld 一下
待渲染模版：
```
 <div id="t1">
    <h1 jscontent="title"></h1>
    <ul>
      <li jscontent="$this" jsselect="favs"></li>
    </ul>
  </div>
```
编写调用js：
```
function showData(data) {
      // This is the javascript code that processes the template:
      var input = new JsEvalContext(data);  //初始化数据
      var output = document.getElementById('t1'); //输出模版
      jstProcess(input, output);
    }
```

调用showData(data)即可完成渲染。

  * 进阶介绍
  1. JsEvalContext 存储jstemplate运行时的数据，它具有构造函数JsEvalContext(data)传入初始数据。data可以是字符串也可以是json数据。另外，JsEvalContext具有 setVariable方法可以随时压入数据。
```
 var mydata = {dataProperty: 'Nonny'};
  var context = new JsEvalContext(mydata);
  context.setVariable('declaredVar', 'Ho');
```
  1. this 和 $this
> > this即为模版定义的html的某个节点，而$this是该节点绑定的context的数据。如：
```
  <div id="witha">
  <div id="Hey" jscontent="this.parentNode.id + this.id + 
      dataProperty + $this.dataProperty + declaredVar"></div>
  </div>
```
> > 这里this即为Hey div。而$this为绑定的context。
  1. 有用属性介绍
  * jscontent
  * jsselect
  * jsdisplay
  * transclude
  * jsvalues & jsvars
  * jseval
  * jsskip

> 这些属性标签的用法在官方介绍中都有讲到，大家可以到那里学习。
> http://code.google.com/intl/zh-CN/apis/jstemplate/docs/instructions-ref.html

### 2.jquery template plugin ###
#### 官网地址 ####
http://archive.plugins.jquery.com/project/Templates
官方博客对他的介绍比较详细：
http://ivorycity.com/blog/jquery-template-plugin/
#### 使用介绍 ####
该库是jquery的插件，短小精悍，使用方便，对以一般场景的html拼接已经足够。
  1. 基本介绍
```
$( selector ).render( values, options ); 

selector:
  The jQuery selector that targets a template in the html document

values:
  A {key:value} set of tokens and replacements,
  or an array of {key:value} replacements to be rendered onto
  multiple templates

options:
{
  clone:
    (true|false) Set to true if you want to clone the template,
    rather than simply replacing values. Defaults to false.

  preserve_template:
     By default the template is overwritten with new values,
     which means it cannot be used again.
     Set preserve_template:true if you want to keep the
     un-rendered template in the DOM. Typically you will
     want to set your template to display:none so you
     can't see the un-rendered tokens.
     Defaults to false.

  beforeUpdate: Callback to do an action before the template is
           updated with values.
           function( new_node ) {}

  afterUpdate: Callback to do an action after the template is updated
            and rendered in the document.
            function( new_node ) {}
}
```
1.简单helloworld
```
<div id="hello_world" >
  It is said, every great programmer begins with:
  {token1}, <span>{token2}</span>
</div>
$(document).ready( function()
{

  $('#hello_world').render( {
    'token0': 'hello_world',
    'token1': 'hello',
    'token2': 'world'
   });

});

```
渲染结果：
Great programmers begin with: hello, world

2.更多用法
> 由于博客写的很详细，大家直接参考即可：
> http://ivorycity.com/blog/jquery-template-plugin/

### 3.mustache ###
这个框架也比较流行，并且是jquery template plugin作者所推荐，应该说，是未来的一个趋势。我们也简单看看。
#### 官方地址 ####
https://github.com/janl/mustache.js
#### 使用介绍 ####
该库不仅能独立执行，还可以和很多流行插件集成
  * Query
  * ojo
  * UI
  * equireJS
  * ooxdoo

> 具体用法大同小异，可以直接参考官方例子
### 总结 ###
鉴于我们一般的使用场景，推荐使用jquery template plugin来简化开发，不使用jstemplate的原因主要是相对于第二种略显麻烦，虽然功能更显强大，但大多数情况下后者已经够用。

两个源代码我已上传，可直接下载。