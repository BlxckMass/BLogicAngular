import {Component} from "@angular/core";
import {Person} from "../../model/person/person";
import {DynamicDatabaseService} from "../../service/dynamic-database/dynamic-database.service";
import {PersonService} from "../../service/person/person.service";
import {PersonTableService} from "../../service/person/person-table.service";
import {TabService} from "../../service/tab/tab.service";
import {TreeService} from "../../service/tree/tree.service";
import {Post} from "../../model/person/post";

@Component({
  selector: 'add-person',
  templateUrl: '../../view/person/add-person.component.html'
})
export class AddPersonComponent {

  id: any;
  person!: Person;
  posts: any[] = [];

  constructor(private dynamicDatabase: DynamicDatabaseService,
              private personService: PersonService,
              private personTableService: PersonTableService,
              private tabService: TabService,
              private treeService: TreeService) {
  }

  savePerson() {
    this.personService.updatePerson(this.person).subscribe((data: any) => {
      this.treeService.dataSource.data = this.dynamicDatabase.initialData();
      this.personTableService.refreshTable();
      this.tabService.removeOpenedTab();
    });
  }

  ngOnInit() {
    this.person = this.personService.createNewPerson();
    this.posts = this.personService.getPosts();
    this.id = this.tabService.id;
  }

  public objectComparisonFunction = function(option: any, value: any) : boolean {
    return option.id === value.id;
  }

  closeTab() {
    this.tabService.removeOpenedTab();
  }
}
