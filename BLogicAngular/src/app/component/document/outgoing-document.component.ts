import {Component} from "@angular/core";
import {Outgoing} from "../../model/document/outgoing";
import {TabService} from "../../service/tab/tab.service";
import {HttpClient} from "@angular/common/http";
import {DialogService} from "../../service/dialog/dialog.service";
import {TreeService} from "../../service/tree/tree.service";
import {DynamicDatabaseService} from "../../service/dynamic-database/dynamic-database.service";
import {OutgoingDocumentService} from "../../service/document/outgoing-document.service";

@Component({
  selector: 'outgoing-document',
  templateUrl: '../../view/document/outgoing-document.component.html'
})
export class OutgoingDocumentComponent {

  // @ts-ignore
  outgoing: Outgoing;

  constructor(private outgoingService: OutgoingDocumentService,
              private tabService: TabService,
              private dialogService: DialogService,
              private treeService: TreeService,
              private dynamicDatabase: DynamicDatabaseService) {
  }

  ngOnInit() {
    this.outgoingService.getOutgoingById(this.tabService.id).subscribe((data: Outgoing) => {
      this.outgoing = data;
      console.log(this.outgoing)
    })
  }

  deleteDocument() {
    this.dialogService.openDeleteOutgoingDialog(this.outgoing.id);
    this.treeService.dataSource.data = this.dynamicDatabase.initialData();
  }

  closeTab() {
    this.tabService.removeOpenedTab();
  }
}
