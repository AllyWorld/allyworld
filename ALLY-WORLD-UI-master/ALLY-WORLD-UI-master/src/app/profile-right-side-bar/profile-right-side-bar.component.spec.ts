import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileRightSideBarComponent } from './profile-right-side-bar.component';

describe('ProfileRightSideBarComponent', () => {
  let component: ProfileRightSideBarComponent;
  let fixture: ComponentFixture<ProfileRightSideBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileRightSideBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileRightSideBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
