import {FlatTreeControl} from '@angular/cdk/tree';
import {Component} from '@angular/core';
import {TabService} from "../../service/tab/tab.service";
import {TreeService} from "../../service/tree/tree.service";
import {DynamicDatabaseService} from "../../service/dynamic-database/dynamic-database.service";
import {DynamicDataSource} from "../../model/dynamic-database/dynamic-data-source";
import {DynamicFlatNode} from "../../model/dynamic-database/dynamic-flat-node";

/**
 * @title Tree with dynamic data
 */
@Component({
  selector: 'tree-view',
  templateUrl: '../../view/tree/tree.component.html',
  styleUrls: ['../../css/tree/tree.component.css']
})
export class TreeComponent {
  constructor(public treeService: TreeService, database: DynamicDatabaseService, public tabService: TabService) {
  }

  getDataSource(): DynamicDataSource {
    return this.treeService.dataSource;
  }

  getTreeControl(): FlatTreeControl<DynamicFlatNode> {
    return this.treeService.treeControl;
  }
  // addTabForNodeType(node: DynamicFlatNode, title: string, type: string) {
  //   if (type == 'updatePerson') {
  //
  //   }
  //   console.log(node);
  //   this.tabService.addTab(title, type, node.item.id);
  // }
  getLevel = (node: DynamicFlatNode) => node.level;
  isExpandable = (node: DynamicFlatNode) => node.expandable;
  hasChild = (_: number, _nodeData: DynamicFlatNode) => _nodeData.expandable;
}
