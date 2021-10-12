import {Component} from "@angular/core";
import {Task} from "../../model/document/task";
import {TabService} from "../../service/tab/tab.service";
import {HttpClient} from "@angular/common/http";
import {TaskDocumentService} from "../../service/document/task-document.service";
import {DialogService} from "../../service/dialog/dialog.service";
import {TreeService} from "../../service/tree/tree.service";
import {DynamicDatabaseService} from "../../service/dynamic-database/dynamic-database.service";

@Component({
  selector: 'task-document',
  templateUrl: '../../view/document/task-document.component.html'
})
export class TaskDocumentComponent {

  // @ts-ignore
  task: Task;

  constructor(private taskService: TaskDocumentService,
              private tabService: TabService,
              private dialogService: DialogService,
              private treeService: TreeService,
              private dynamicDatabase: DynamicDatabaseService) {
  }

  ngOnInit() {
    this.taskService.getTaskById(this.tabService.id).subscribe((data: Task) => {
      this.task = data;
      console.log(this.task)
    })
  }

  deleteDocument() {
    this.dialogService.openDeleteTaskDialog(this.task.id);
    this.treeService.dataSource.data = this.dynamicDatabase.initialData();
  }

  closeTab() {
    this.tabService.removeOpenedTab();
  }
}
