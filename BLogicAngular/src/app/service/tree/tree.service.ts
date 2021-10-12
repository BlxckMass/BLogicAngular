import {Injectable} from "@angular/core";
import {TabService} from "../tab/tab.service";
import {FlatTreeControl} from "@angular/cdk/tree";
import {DynamicDatabaseService} from "../dynamic-database/dynamic-database.service";
import {DynamicDataSource} from "../../model/dynamic-database/dynamic-data-source";
import {DynamicFlatNode} from "../../model/dynamic-database/dynamic-flat-node";

@Injectable()
export class TreeService {

  treeControl: FlatTreeControl<DynamicFlatNode>;
  dataSource: DynamicDataSource;

  constructor(database: DynamicDatabaseService, public tabService: TabService) {
    this.treeControl = new FlatTreeControl<DynamicFlatNode>(this.getLevel, this.isExpandable);
    this.dataSource = new DynamicDataSource(this.treeControl, database);
    this.dataSource.data = database.initialData();
  }

  getLevel = (node: DynamicFlatNode) => node.level;

  isExpandable = (node: DynamicFlatNode) => node.expandable;

  hasChild = (_: number, _nodeData: DynamicFlatNode) => _nodeData.expandable;
}
