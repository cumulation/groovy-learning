package com.monical.groovy.learning.ast

import groovy.transform.ToString
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.ConstructorCallExpression
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ReturnStatement
import org.codehaus.groovy.ast.tools.GeneralUtils

/**
 * @author monical* @date 2020-04-27 11:28:24
 */
@ToString
class POGO {
    String name
}

def pogo = new POGO(name: 'hello groovy')
// com.monical.groovy.learning.ast.POGO@436813f3
println pogo
// 1.creating by hand
def b_ast = new ReturnStatement(new ConstructorCallExpression(ClassHelper.make(Date), ArgumentListExpression.EMPTY_ARGUMENTS))
assert b_ast instanceof ReturnStatement
// 2.creating by hand (using the GeneralUtils helper class)
def ast = GeneralUtils.returnS(GeneralUtils.ctorX(ClassHelper.make(Date)))
assert ast instanceof ReturnStatement
// 3.AstBuilder.buildFromSpec
def a_ast = new AstBuilder().buildFromSpec { returnStatement { constructorCall(Date) { argumentList {} } } }
assert a_ast[0] instanceof ReturnStatement

// 4. AstBuilder.buildFromString
def c_ast = new AstBuilder().buildFromString('new Date()')
assert c_ast[0] instanceof BlockStatement
println c_ast[0].metaClass.methods
assert c_ast[0].statements[0] instanceof ReturnStatement