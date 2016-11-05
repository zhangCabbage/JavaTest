package zhang.algorithm.JavaTest.JVM.Compiler;


import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner6;
import javax.tools.Diagnostic;
import java.util.EnumSet;

import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;
import static javax.lang.model.element.Modifier.FINAL;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/5
 * Time: 下午8:14
 * To change this template use File | Settings | File Templates.
 * <p>
 * 程序名称规范的编译器插件:
 * 如果程序命名不和规范, 将会输出一个编译器的 WARNNING 信息
 */
public class NameChecker {
    private final Messager message;

    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    NameChecker(ProcessingEnvironment processingEnv) {
        this.message = processingEnv.getMessager();
    }

    public void checkNames(Element element) {
        nameCheckScanner.scan(element);
    }

    /**
     * 名称检查器实现类<br>
     * 将会以Visitor模式访问抽象语法树种的元素
     */
    private class NameCheckScanner extends ElementScanner6<Void, Void> {
        /**
         * 用于检查Java类
         *
         * @param e
         * @param aVoid
         * @return
         */
        @Override
        public Void visitType(TypeElement e, Void aVoid) {
            scan(e.getTypeParameters(), aVoid);
            checkCamelCase(e, true);
            super.visitType(e, aVoid);
            return null;
        }

        /**
         * 用于检查Java方法
         *
         * @param e
         * @param aVoid
         * @return
         */
        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if (e.getKind() == ElementKind.METHOD) {
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
                    message.printMessage(Diagnostic.Kind.WARNING, "一个普通方法不应该与类名重复");
                }
                checkCamelCase(e, false);
            }
            super.visitExecutable(e, aVoid);
            return null;
        }

        /**
         * 检查变量命名
         *
         * @param e
         * @param aVoid
         * @return
         */
        @Override
        public Void visitVariable(VariableElement e, Void aVoid) {
            //如果是枚举或者常量, 则按照大写命名检查
            if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null && isConstant(e)) {
                //TODO
            } else {
                //TODO
            }
            return null;
        }

        private boolean isConstant(VariableElement e) {
            if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE) {
                return true;
            } else if (e.getKind() == ElementKind.FIELD && e.getModifiers().containsAll(EnumSet.of(PUBLIC, STATIC, FINAL))) {
                return true;
            } else {
                return false;
            }
        }

        private void checkCamelCase(Element e, boolean b) {
        }

    }
}
