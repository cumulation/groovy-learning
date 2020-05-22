### File to class relationship
>> 文件和类的关系
1. If a Groovy file contains no class declaration, it’s handled as a script; 
that is, it’s transparently wrapped into a class of type Script. 
This automatically generated class has the same name as the source script filename7(without the extension).
The content of the file is wrapped into a run method, and an additional main method is constructed for easily starting the script.

>> 如Groovy 文件不包含 class 声明，会被当成一个脚本，也就是说它会透明包装称一个脚本。会自动生成一个和 文件名同名的类。
该Groovy 文件的内容会被包装成一个 run 方法 和一个 用来轻松启动脚本的main 方法。

2. If a Groovy file contains exactly one class declaration with the same name as the file(without the extension), then there’s the same one-to-one relationship as in Java.
>> 若一个Groovy 文件完全包含一个同名的class 声明，那它和java 是等同的

3. A Groovy file may contain multiple class declarations of any visibility, 
and there’s no enforced rule that any of them must match the filename. The groovyc compiler happily creates *.class files for all declared classes in such a file. 
If you wish to invoke your script directly—for example, 
using groovy on the command line or within an IDE—then the first class within your file should have a main method
>> 一个Groovy 文件可能包含多个可见性的 class 声明，不要求他们跟文件名匹配，groovyc 编译器会创建多个class 文件的声明，如果你想直接通过命令
行或IDE 调用脚本，文件的第一个 class 必须含有一个 main 方法

4. A Groovy file may mix class declarations and scripting code. In this case, the 
scripting code will become the main class to be executed, so don’t declare a class yourself having the same name as the source filename. 
>> 一个groovy 文件可能混合 class 声明和 脚本代码，这种场景下，脚本代码会变成 main 类去执行，所以不要在该文件里包含 同文件名的 class 声明

### 使用GPath
Writing less code isn’t just an exercise for its own sake. 
    Whereas some new developersthink of a good day as one in which they’ve added lots of lines to the codebase, we consider a really good day as one in which we’ve added functionality but removed lines from the codebase.
>> 编写更少的代码本身并不是一项练习。
       尽管有些新开发人员将美好的一天看作是在代码库中添加了很多行的日子，但我们认为真的很美好的一天是在其中添加了功能但删除了代码库的行。