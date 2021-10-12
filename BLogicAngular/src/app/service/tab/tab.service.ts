import {Tab} from "../../model/tab/tab";
import {FormControl} from "@angular/forms";
import {Injectable} from "@angular/core";

@Injectable()
export class TabService {

  private tabs = [new Tab(1, "Приветствие", "hello")];
  id: any;
  selected = new FormControl(0);

  addTab(title: string, type: string, id: any) {
    if (!this.checkDuplicateTab(id, type)) {
      this.tabs.push(new Tab(id, title, type));
      this.selected.setValue(this.tabs.length - 1);
      this.id = id;
    }
  }

  addTabForNodeType(id: number, title: string, type: string) {
      this.addTab(title, type, id);
  }

  removeTab(index: number) {
    this.tabs.splice(index, 1);
  }

  removeOpenedTab() {
    this.removeTab(this.selected.value);
  }

  checkDuplicateTab(id: number, type: string): boolean {
    for (let i = 0; i < this.tabs.length; i++) {
      let currentTab = this.tabs[i];
      if (currentTab.id == id && currentTab.type == type) {
        this.selected.setValue(i);
        return true;
      }
    }
    return false;
  }

  getTabs(): Tab[] {
    return this.tabs;
  }

  // @ts-ignore
  getTab(): Tab {
    let pop = this.tabs.slice(this.selected.value, this.selected.value + 1).pop();
    return <Tab>pop;
  }

  getSelected(): FormControl {
    return this.selected;
  }
}
