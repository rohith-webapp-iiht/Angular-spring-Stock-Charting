import { Directive, ViewContainerRef, ContentChildren } from '@angular/core';
import { ComplexBase, ArrayBase, setValue } from '@syncfusion/ej2-angular-base';



let input: string[] = ['interval', 'intervalType', 'selected', 'text'];
let outputs: string[] = [];
/**
 * Indicator Directive
 * ```html
 * <e-stockchart-periods>
 * <e-stockchart-period></e-stockchart-period>
 * </e-stockchart-periods>
 * ```
 */
@Directive({
    selector: 'e-stockchart-indicators>e-stockchart-period',
    inputs: input,
    outputs: outputs,    
    queries: {

    }
})
export class StockChartPeriodDirective extends ComplexBase<StockChartPeriodDirective> {
    public directivePropList: any;


    /** 
     * Count value for the button
     * @default 1
     */
    public interval: any;
    /** 
     * IntervalType of button
     * @default 'Years'
     */
    public intervalType: any;
    /** 
     * To select the default period
     * @default false
     */
    public selected: any;
    /** 
     * Text to be displayed on the button
     * @default null
     */
    public text: any;

    constructor(private viewContainerRef:ViewContainerRef) {
        super();
        setValue('currentInstance', this, this.viewContainerRef);
        this.registerEvents(outputs);
        this.directivePropList = input;
    }
}

/**
 * StockChartPeriod Array Directive
 * @private
 */
@Directive({
    selector: 'ejs-stockchart>e-stockchart-periods',
    queries: {
        children: new ContentChildren(StockChartPeriodDirective)
    },
})
export class StockChartPeriodsDirective extends ArrayBase<StockChartPeriodsDirective> {
    constructor() {
        super('periods');
    }
}