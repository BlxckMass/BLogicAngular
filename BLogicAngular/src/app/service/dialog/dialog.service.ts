import {MatDialog} from "@angular/material/dialog";
import {Injectable} from "@angular/core";
import {DeletePersonDialogComponent} from "../../component/dialog/delete-person-dialog.component";
import {TabService} from "../tab/tab.service";
import {PersonTableService} from "../person/person-table.service";
import {DeleteTaskDialogComponent} from "../../component/dialog/delete-task-dialog.component";
import {DeleteOutgoingDialogComponent} from "../../component/dialog/delete-outgoing-dialog.component";
import {DeleteIncomingDialogComponent} from "../../component/dialog/delete-incoming-dialog.component";

@Injectable()
export class DialogService {

  constructor(public dialog: MatDialog, private tabService: TabService, private personTableService: PersonTableService) {
  }

  openDeletePersonDialog(id: string) {
    this.dialog.open(DeletePersonDialogComponent, {
      data: {id: id}
    }).afterClosed().subscribe(value => {
      this.personTableService.refreshTable();
    })
  }

  openDeleteTaskDialog(id: string) {
    this.dialog.open(DeleteTaskDialogComponent, {
      data: {id: id}
    });
  }

  openDeleteOutgoingDialog(id: string) {
    this.dialog.open(DeleteOutgoingDialogComponent, {
      data: {id: id}
    });
  }

  openDeleteIncomingDialog(id: string) {
    this.dialog.open(DeleteIncomingDialogComponent, {
      data: {id: id}
    });
  }
}
