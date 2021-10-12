import {ChangeDetectorRef, Component} from "@angular/core";
import {PersonService} from "../../service/person/person.service";
import {TabService} from "../../service/tab/tab.service";
import {Person} from "../../model/person/person";
import {DynamicDatabaseService} from "../../service/dynamic-database/dynamic-database.service";
import {TreeService} from "../../service/tree/tree.service";
import {DataSource} from "@angular/cdk/collections";
import {DynamicDataSource} from "../../model/dynamic-database/dynamic-data-source";
import {DialogService} from "../../service/dialog/dialog.service";
import {PersonTableService} from "../../service/person/person-table.service";

@Component({
  selector: 'person',
  templateUrl: '../../view/person/update-person.component.html',
})
export class UpdatePersonComponent {
  id: any;
  // @ts-ignore
  person: Person;
  posts: any[] = [];

  constructor(private dynamicDatabase: DynamicDatabaseService,
              private personService: PersonService,
              private personTableService: PersonTableService,
              private tabService: TabService,
              private treeService: TreeService,
              private dialogService: DialogService) {
  }

  updatePerson() {
    this.personService.updatePerson(this.person).subscribe((data: any) => {
      this.treeService.dataSource.data = this.dynamicDatabase.initialData();
      this.personTableService.refreshTable();
      this.tabService.removeOpenedTab();
    });
  }

  deletePerson() {
    this.dialogService.openDeletePersonDialog(this.person.id);
    this.treeService.dataSource.data = this.dynamicDatabase.initialData();
  }

  ngOnInit() {
    this.posts = this.personService.getPosts();
    this.id = this.tabService.id;
    console.log(this.tabService.id);
    this.personService.getPersonById(this.id).subscribe((data: Person) => {
      console.log(data);
      this.person = data;
    });
  }

  public objectComparisonFunction = function(option: any, value: any) : boolean {
    return option.id === value.id;
  }

  initPerson(id: bigint) {
    this.personService.getPersonById(id).subscribe((data: Person) => {
      this.person = data;
    });
  }

  closeTab() {
    this.tabService.removeOpenedTab();
  }
}
