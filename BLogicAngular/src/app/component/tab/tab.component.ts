import {Component} from "@angular/core";
import {Tab} from "../../model/tab/tab";
import {FormControl} from "@angular/forms";
import {TabService} from "../../service/tab/tab.service";

@Component({
  selector: 'tabs',
  templateUrl: '../../view/tab/tab.component.html'
})
export class TabComponent {

  constructor(private tabService: TabService) {
  }

  // addTab(title: string, type: string, id: any) {
  //   this.tabService.addTab(title, type);
  //   this.id = id;
  // }

  removeTab(index: number) {
    this.tabService.removeTab(index);
  }

  getTabs(): Tab[] {
    return this.tabService.getTabs();
  }

  getSelected(): FormControl {
    return this.tabService.getSelected();
  }
}
