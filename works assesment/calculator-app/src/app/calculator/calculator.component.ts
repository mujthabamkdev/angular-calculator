import { Component } from '@angular/core';


@Component({
  selector: 'app-Calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent {
  inp1: number;
  inp2: number;
  result: number;
  symbol: string = "+";
  count: number = 0;
  selectedOperator: string = "+";

  resetInputs() {
    this.inp1 = undefined;
    this.inp2 = undefined;
    this.symbol = "+";
    this.result = undefined;
  }

  calculate(key: string) {
    this.symbol = key;
    switch (key) {
      case "+":
        this.result = this.inp1 + this.inp2;
        break;
      case "-":
        this.result = this.inp1 - this.inp2;
        break;
      case "/":
        this.result = this.inp1 / this.inp2;
        break;
      case "*":
        this.result = this.inp1 * this.inp2;
        break;
      default:
        this.result = 0;

    }
  }

}
