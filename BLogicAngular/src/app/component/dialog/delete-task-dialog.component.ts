import {Component, Inject} from "@angular/core";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";
import {TaskDocumentService} from "../../service/document/task-document.service";
import {TabService} from "../../service/tab/tab.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'delete-person-dialog',
  templateUrl: '../../view/dialog/delete-document-dialog.component.html',
})
export class DeleteTaskDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: {id: string},
              private _snackBar: MatSnackBar,
              private taskService: TaskDocumentService,
              private tabService: TabService,
              private http: HttpClient) {
  }

  deleteDocument() {
    this.taskService.deleteTaskById(this.data.id).subscribe(
      (data: any) => {
        this.tabService.removeOpenedTab();
        return data;
      },
      error => {
        let data = error.error;
        this._snackBar.open(data.message, 'Закрыть');
      }
    );
  }
}
