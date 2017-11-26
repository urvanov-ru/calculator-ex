module ru.urvanov.calculatorex.standardplugin {
    requires ru.urvanov.calculatorex;
    provides ru.urvanov.calculatorex.plugin.Operation
            with ru.urvanov.calculatorex.plugin.standard.Sum;
}
                                