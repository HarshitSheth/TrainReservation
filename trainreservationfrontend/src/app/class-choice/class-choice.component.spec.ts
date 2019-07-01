import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassChoiceComponent } from './class-choice.component';

describe('ClassChoiceComponent', () => {
  let component: ClassChoiceComponent;
  let fixture: ComponentFixture<ClassChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClassChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClassChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
