module ru.urvanov.calculatorex.standardplugin {
    requires ru.urvanov.calculatorex;
    provides ru.urvanov.calculatorex.plugin.Operation
            with ru.urvanov.calculatorex.plugin.standard.Clear,
            ru.urvanov.calculatorex.plugin.standard.Sum,
            ru.urvanov.calculatorex.plugin.standard.Minus,
            ru.urvanov.calculatorex.plugin.standard.Multiply,
            ru.urvanov.calculatorex.plugin.standard.Divide;
}
                                           